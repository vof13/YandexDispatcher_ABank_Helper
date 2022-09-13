package com.yahelper.yandexdispatcher_abank_helper;

import com.yahelper.yandexdispatcher_abank_helper.entity.EntityProfile;
import com.yahelper.yandexdispatcher_abank_helper.entity.EntityRule;
import com.yahelper.yandexdispatcher_abank_helper.entity.EntityTransactions;
import com.yahelper.yandexdispatcher_abank_helper.repository.ProfilesRepository;
import com.yahelper.yandexdispatcher_abank_helper.repository.TransactionsRepository;
import com.yahelper.yandexdispatcher_abank_helper.repository.WorkRulesRepository;
import com.yahelper.yandexdispatcher_abank_helper.rest.driverprofiles.response.ProfilesResponse;
import com.yahelper.yandexdispatcher_abank_helper.rest.driverwokrules.RestRule;
import com.yahelper.yandexdispatcher_abank_helper.rest.transactions.TransactionResponse;
import com.yahelper.yandexdispatcher_abank_helper.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private final WorkRulesRepository workRulesRepository;
    private final ProfilesRepository profilesRepository;
    private final TransactionsRepository transactionsRepository;

    private final TransactionService transactionService;
    private final ProfilesService profilesService;
    private final WorkRulesService workRulesService;

    public MainController(WorkRulesService workRulesService,
                          WorkRulesRepository workRulesRepository,
                          ProfilesRepository profilesRepository, TransactionsRepository transactionsRepository, TransactionService transactionService,
                          ProfilesService profilesService) {
        this.workRulesService = workRulesService;
        this.workRulesRepository = workRulesRepository;
        this.profilesRepository = profilesRepository;
        this.transactionsRepository = transactionsRepository;
        this.transactionService = transactionService;
        this.profilesService = profilesService;
    }

    @GetMapping(value = "/")
    public String showUserList(Model model) {
        model.addAttribute("users", profilesRepository.findAll());
        return "index.html";
    }

    @GetMapping(value ="/rules/")
    private void createRulesTable() {
        for (RestRule restrule: workRulesService.getRules().getRulesList()
             ) {
            EntityRule entityRule = new EntityRule(
                    restrule.getName()
            );
            workRulesRepository.save(entityRule);
        }
    }

    @GetMapping(value ="/transactions/")
    private String getTransactions(Model model){
        List<TransactionResponse> responseList = transactionService.restGetTransaction().getTransactionResponses();

        List<EntityTransactions> transactionsList = responseList.stream()
                        .map( el -> {
                            EntityTransactions entityTransactions = new EntityTransactions();
                            entityTransactions.setDriverProfileId(el.getDriverProfileId());
                            entityTransactions.setAmount(el.getAmount());
                            entityTransactions.setCategoryName(el.getCategoryName());
                            return entityTransactions;
                        })
                                .collect(Collectors.toList());
        transactionsRepository.saveAll(transactionsList);
        model.addAttribute("transactionsList", transactionsList);
        return "transactions";
    }

    @GetMapping(value = "/profiles/")
    private String getProfiles(Model model) {
        List<ProfilesResponse> responseList = profilesService.restGetProfiles().getProfilesResponses();

        List<EntityProfile> profilesList = responseList.stream()
                .map(el -> {
                    EntityProfile entityProfile = new EntityProfile();
                    entityProfile.setId(el.getDriverProfile().getId());
                    entityProfile.setCallsign(el.getCar().getCallsign());
                    entityProfile.setLastName(el.getDriverProfile().getLastName());
                    entityProfile.setFirstName(el.getDriverProfile().getFirstName());
                    entityProfile.setMiddleName(el.getDriverProfile().getMiddleName());
                    entityProfile.setBalance(el.getAccounts().get(0).getBalance());
                    return entityProfile;
                })
                .collect(Collectors.toList());
        profilesRepository.saveAll(profilesList);
        model.addAttribute("profilesList", profilesList);
        return "profiles";
    }
}
