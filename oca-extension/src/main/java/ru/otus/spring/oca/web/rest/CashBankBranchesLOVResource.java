package ru.otus.spring.oca.web.rest;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.core.TypeReferences;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.otus.spring.oca.domain.CashBankBranchesLOV;
import ru.otus.spring.oca.domain.CashBanksLOV;
import ru.otus.spring.oca.domain.StandardReceipt;
import ru.otus.spring.oca.service.mapper.HalMapper;
import ru.otus.spring.oca.service.Utils;
import ru.otus.spring.oca.web.rest.errors.BadRequestAlertException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * REST controller for managing {@link ru.otus.spring.oca.domain.CashBankBranchesLOV}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class CashBankBranchesLOVResource {

    private final Logger log = LoggerFactory.getLogger(CashBankBranchesLOVResource.class);

    private static final String ENTITY_NAME = "cashBankBranchesLOV";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final String RESTAPIURL;
    private RestTemplate restTemplate;
    private HalMapper<CashBankBranchesLOV> halMapper;

    public CashBankBranchesLOVResource(
        RestTemplate restTemplate,
        HalMapper<CashBankBranchesLOV> halMapper
    ) {
        this.RESTAPIURL = "https://egxt-dev4.fa.em2.oraclecloud.com" +
            "/fscmRestApi/resources/11.13.18.05/cashBankBranchesLOV";
        this.restTemplate = restTemplate;
        this.halMapper = halMapper;
    }

    /**
     * {@code POST  /cash-bank-branches-lovs} : Create a new cashBankBranchesLOV.
     *
     * @param cashBankBranchesLOV the cashBankBranchesLOV to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cashBankBranchesLOV, or with status {@code 400 (Bad Request)} if the cashBankBranchesLOV has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cash-bank-branches-lovs")
    public ResponseEntity<CashBankBranchesLOV> createCashBankBranchesLOV(@RequestBody CashBankBranchesLOV cashBankBranchesLOV) throws URISyntaxException {
        log.debug("REST request to save CashBankBranchesLOV : {}", cashBankBranchesLOV);
        if (cashBankBranchesLOV.getBranchPartyId() != null) {
            throw new BadRequestAlertException("A new cashBankBranchesLOV cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CashBankBranchesLOV result = null; // cashBankBranchesLOVRepository.save(cashBankBranchesLOV);
        return ResponseEntity.created(new URI("/api/cash-bank-branches-lovs/" + result.getBranchPartyId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getBranchPartyId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cash-bank-branches-lovs} : Updates an existing cashBankBranchesLOV.
     *
     * @param cashBankBranchesLOV the cashBankBranchesLOV to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cashBankBranchesLOV,
     * or with status {@code 400 (Bad Request)} if the cashBankBranchesLOV is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cashBankBranchesLOV couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cash-bank-branches-lovs")
    public ResponseEntity<CashBankBranchesLOV> updateCashBankBranchesLOV(@RequestBody CashBankBranchesLOV cashBankBranchesLOV) throws URISyntaxException {
        log.debug("REST request to update CashBankBranchesLOV : {}", cashBankBranchesLOV);
        if (cashBankBranchesLOV.getBranchPartyId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CashBankBranchesLOV result = null; // cashBankBranchesLOVRepository.save(cashBankBranchesLOV);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cashBankBranchesLOV.getBranchPartyId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /cash-bank-branches-lovs} : get all the cashBankBranchesLOVS.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cashBankBranchesLOVS in body.
     */
    @GetMapping("/cash-bank-branches-lovs")
    public ResponseEntity<List<CashBankBranchesLOV>> getAllCashBankBranchesLOVS(Pageable pageable) {
        log.debug("REST request to get a page of CashBankBranchesLOVS");

        int offset = pageable.getPageNumber();
        int limit = pageable.getPageSize();
        // TODO: ?q - доавить
        String ServiceURL = Utils.getServiceURL(RESTAPIURL,"",offset,limit);
        ResponseEntity<EntityModel<Map<String,CashBankBranchesLOV[]>>> responseEntity =
            restTemplate.exchange(ServiceURL, HttpMethod.GET, null,
                new TypeReferences.EntityModelType<Map<String,CashBankBranchesLOV[]>>() {},
                Collections.emptyMap());

        List<CashBankBranchesLOV> all =
            halMapper.process((LinkedHashMap)responseEntity.getBody().getContent(), CashBankBranchesLOV.class);

        Page<CashBankBranchesLOV> page = new PageImpl<>(all, pageable, all.size());
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cash-bank-branches-lovs/:id} : get the "id" cashBankBranchesLOV.
     *
     * @param id the id of the cashBankBranchesLOV to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cashBankBranchesLOV, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cash-bank-branches-lovs/{id}")
    public ResponseEntity<CashBankBranchesLOV> getCashBankBranchesLOV(@PathVariable Long id) {
        log.debug("REST request to get CashBankBranchesLOV : {}", id);

        String URL = RESTAPIURL + "/" + id;

        ResponseEntity<EntityModel<Map<String, CashBankBranchesLOV>>> responseEntity =
            restTemplate.exchange(URL, HttpMethod.GET, null,
                new TypeReferences.EntityModelType<Map<String,CashBankBranchesLOV>>() {},
                Collections.emptyMap());

        Optional<CashBankBranchesLOV> cashBankBranchesLOV = Optional.empty();
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            LinkedHashMap map = (LinkedHashMap) responseEntity.getBody().getContent();
            cashBankBranchesLOV = Optional.of(halMapper.processEntity(map,CashBankBranchesLOV.class));
        }

        return ResponseUtil.wrapOrNotFound(cashBankBranchesLOV);
    }

    /**
     * {@code DELETE  /cash-bank-branches-lovs/:id} : delete the "id" cashBankBranchesLOV.
     *
     * @param id the id of the cashBankBranchesLOV to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cash-bank-branches-lovs/{id}")
    public ResponseEntity<Void> deleteCashBankBranchesLOV(@PathVariable Long id) {
        log.debug("REST request to delete CashBankBranchesLOV : {}", id);
        // cashBankBranchesLOVRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
