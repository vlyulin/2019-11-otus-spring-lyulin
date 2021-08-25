package ru.otus.spring.oca.web.rest;

import org.springframework.data.domain.PageImpl;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.core.TypeReferences;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;
import ru.otus.spring.oca.domain.CashBankAccountsLOV;
import ru.otus.spring.oca.domain.CashBankBranchesLOV;
import ru.otus.spring.oca.service.mapper.HalMapper;
import ru.otus.spring.oca.service.Utils;
import ru.otus.spring.oca.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * REST controller for managing {@link ru.otus.spring.oca.domain.CashBankAccountsLOV}.
 */
@RestController
@RequestMapping("/api")
public class CashBankAccountsLOVResource {

    private final Logger log = LoggerFactory.getLogger(CashBankAccountsLOVResource.class);

    private static final String ENTITY_NAME = "cashBankAccountsLOV";

    private final String RESTAPIURL;
    private RestTemplate restTemplate;
    private HalMapper<CashBankAccountsLOV> halMapper;

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    public CashBankAccountsLOVResource(
        RestTemplate restTemplate,
        HalMapper<CashBankAccountsLOV> halMapper
    ) {
        RESTAPIURL = "https://egxt-dev4.fa.em2.oraclecloud.com" +
            "/fscmRestApi/resources/11.13.18.05/cashBankAccountsLOV";
        this.restTemplate = restTemplate;
        this.halMapper = halMapper;
    }

    /**
     * {@code POST  /cash-bank-accounts-lovs} : Create a new cashBankAccountsLOV.
     *
     * @param cashBankAccountsLOV the cashBankAccountsLOV to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cashBankAccountsLOV, or with status {@code 400 (Bad Request)} if the cashBankAccountsLOV has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cash-bank-accounts-lovs")
    public ResponseEntity<CashBankAccountsLOV> createCashBankAccountsLOV(@RequestBody CashBankAccountsLOV cashBankAccountsLOV) throws URISyntaxException {
        log.debug("REST request to save CashBankAccountsLOV : {}", cashBankAccountsLOV);
        if (cashBankAccountsLOV.getBankAccountId() != null) {
            throw new BadRequestAlertException("A new cashBankAccountsLOV cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CashBankAccountsLOV result = null; // cashBankAccountsLOVRepository.save(cashBankAccountsLOV);
        return ResponseEntity.created(new URI("/api/cash-bank-accounts-lovs/" + result.getBankAccountId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getBankAccountId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cash-bank-accounts-lovs} : Updates an existing cashBankAccountsLOV.
     *
     * @param cashBankAccountsLOV the cashBankAccountsLOV to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cashBankAccountsLOV,
     * or with status {@code 400 (Bad Request)} if the cashBankAccountsLOV is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cashBankAccountsLOV couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cash-bank-accounts-lovs")
    public ResponseEntity<CashBankAccountsLOV> updateCashBankAccountsLOV(@RequestBody CashBankAccountsLOV cashBankAccountsLOV) throws URISyntaxException {
        log.debug("REST request to update CashBankAccountsLOV : {}", cashBankAccountsLOV);
        if (cashBankAccountsLOV.getBankAccountId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CashBankAccountsLOV result = null; // cashBankAccountsLOVRepository.save(cashBankAccountsLOV);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cashBankAccountsLOV.getBankAccountId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /cash-bank-accounts-lovs} : get all the cashBankAccountsLOVS.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cashBankAccountsLOVS in body.
     */
    @GetMapping("/cash-bank-accounts-lovs")
    public ResponseEntity<List<CashBankAccountsLOV>> getAllCashBankAccountsLOVS(Pageable pageable) {
        log.debug("REST request to get a page of CashBankAccountsLOVS");

        int offset = pageable.getPageNumber();
        int limit = pageable.getPageSize();

        String ServiceURL = Utils.getServiceURL(RESTAPIURL,"",offset,limit);
        ResponseEntity<EntityModel<Map<String, CashBankAccountsLOV[]>>> responseEntity =
            restTemplate.exchange(ServiceURL, HttpMethod.GET, null,
                new TypeReferences.EntityModelType<Map<String,CashBankAccountsLOV[]>>() {},
                Collections.emptyMap());

        List<CashBankAccountsLOV> all =
            halMapper.process((LinkedHashMap)responseEntity.getBody().getContent(), CashBankAccountsLOV.class);

        Page<CashBankAccountsLOV> page = new PageImpl<>(all, pageable, all.size());
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cash-bank-accounts-lovs/:id} : get the "id" cashBankAccountsLOV.
     *
     * @param id the id of the cashBankAccountsLOV to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cashBankAccountsLOV, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cash-bank-accounts-lovs/{id}")
    public ResponseEntity<CashBankAccountsLOV> getCashBankAccountsLOV(@PathVariable Long id) {
        log.debug("REST request to get CashBankAccountsLOV : {}", id);

        String URL = RESTAPIURL + "/" + id;

        ResponseEntity<EntityModel<Map<String, CashBankAccountsLOV>>> responseEntity =
            restTemplate.exchange(URL, HttpMethod.GET, null,
                new TypeReferences.EntityModelType<Map<String,CashBankAccountsLOV>>() {},
                Collections.emptyMap());

        Optional<CashBankAccountsLOV> cashBankAccountsLOV = Optional.empty();
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            LinkedHashMap map = (LinkedHashMap) responseEntity.getBody().getContent();
            cashBankAccountsLOV = Optional.of(halMapper.processEntity(map,CashBankAccountsLOV.class));
        }

        return ResponseUtil.wrapOrNotFound(cashBankAccountsLOV);
    }

    /**
     * {@code DELETE  /cash-bank-accounts-lovs/:id} : delete the "id" cashBankAccountsLOV.
     *
     * @param id the id of the cashBankAccountsLOV to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cash-bank-accounts-lovs/{id}")
    public ResponseEntity<Void> deleteCashBankAccountsLOV(@PathVariable Long id) {
        log.debug("REST request to delete CashBankAccountsLOV : {}", id);
        // cashBankAccountsLOVRepository.deleteById(id);
        return ResponseEntity.noContent().headers(
            HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}

