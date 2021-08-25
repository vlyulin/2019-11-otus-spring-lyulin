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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.otus.spring.oca.domain.CashBankBranchesLOV;
import ru.otus.spring.oca.domain.CashBanksLOV;
import ru.otus.spring.oca.domain.CustomerAccountSitesLOV;
import ru.otus.spring.oca.service.Utils;
import ru.otus.spring.oca.service.mapper.HalMapper;
import ru.otus.spring.oca.web.rest.errors.BadRequestAlertException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * REST controller for managing {@link ru.otus.spring.oca.domain.CashBanksLOV}.
 */
@RestController
@RequestMapping("/api")
public class CashBanksLOVResource {

    private final Logger log = LoggerFactory.getLogger(CashBanksLOVResource.class);

    private static final String ENTITY_NAME = "cashBanksLOV";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final String RESTAPIURL;
    private RestTemplate restTemplate;
    private HalMapper<CashBanksLOV> halMapper;

    public CashBanksLOVResource(
        RestTemplate restTemplate,
        HalMapper<CashBanksLOV> halMapper
    ) {
        this.RESTAPIURL = "https://egxt-dev4.fa.em2.oraclecloud.com" +
            "/fscmRestApi/resources/11.13.18.05/cashBanks";
        this.restTemplate = restTemplate;
        this.halMapper = halMapper;
    }

    /**
     * {@code POST  /cash-banks-lovs} : Create a new cashBanksLOV.
     *
     * @param cashBanksLOV the cashBanksLOV to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new cashBanksLOV, or with status {@code 400 (Bad Request)} if the cashBanksLOV has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cash-banks-lovs")
    public ResponseEntity<CashBanksLOV> createCashBanksLOV(@RequestBody CashBanksLOV cashBanksLOV) throws URISyntaxException {
        log.debug("REST request to save CashBanksLOV : {}", cashBanksLOV);
        if (cashBanksLOV.getBankPartyId() != null) {
            throw new BadRequestAlertException("A new cashBanksLOV cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CashBanksLOV result = null; // cashBanksLOVRepository.save(cashBanksLOV);
        return ResponseEntity.created(new URI("/api/cash-banks-lovs/" + result.getBankPartyId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getBankPartyId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cash-banks-lovs} : Updates an existing cashBanksLOV.
     *
     * @param cashBanksLOV the cashBanksLOV to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated cashBanksLOV,
     * or with status {@code 400 (Bad Request)} if the cashBanksLOV is not valid,
     * or with status {@code 500 (Internal Server Error)} if the cashBanksLOV couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cash-banks-lovs")
    public ResponseEntity<CashBanksLOV> updateCashBanksLOV(@RequestBody CashBanksLOV cashBanksLOV) throws URISyntaxException {
        log.debug("REST request to update CashBanksLOV : {}", cashBanksLOV);
        if (cashBanksLOV.getBankPartyId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CashBanksLOV result = null; // cashBanksLOVRepository.save(cashBanksLOV);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, cashBanksLOV.getBankPartyId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /cash-banks-lovs} : get all the cashBanksLOVS.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of cashBanksLOVS in body.
     */
    @GetMapping("/cash-banks-lovs")
    public ResponseEntity<List<CashBanksLOV>> getAllCashBanksLOVS(Pageable pageable) {
        log.debug("REST request to get a page of CashBanksLOVS");

        int offset = pageable.getPageNumber();
        int limit = pageable.getPageSize();
        String ServiceURL = Utils.getServiceURL(RESTAPIURL,"",offset,limit);
        ResponseEntity<EntityModel<Map<String,CashBanksLOV[]>>> responseEntity =
            restTemplate.exchange(ServiceURL, HttpMethod.GET, null,
                new TypeReferences.EntityModelType<Map<String,CashBanksLOV[]>>() {},
                Collections.emptyMap());

        List<CashBanksLOV> all =
            halMapper.process((LinkedHashMap)responseEntity.getBody().getContent(), CashBanksLOV.class);

        Page<CashBanksLOV> page = new PageImpl<>(all, pageable, all.size());

        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cash-banks-lovs/:id} : get the "id" cashBanksLOV.
     *
     * @param id the id of the cashBanksLOV to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the cashBanksLOV, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cash-banks-lovs/{id}")
    public ResponseEntity<CashBanksLOV> getCashBanksLOV(@PathVariable Long id) {
        log.debug("REST request to get CashBanksLOV : {}", id);

        String URL = RESTAPIURL + "/" + id;

        ResponseEntity<EntityModel<Map<String, CashBanksLOV>>> responseEntity =
            restTemplate.exchange(URL, HttpMethod.GET, null,
                new TypeReferences.EntityModelType<Map<String,CashBanksLOV>>() {},
                Collections.emptyMap());

        Optional<CashBanksLOV> cashBanksLOV = Optional.empty();
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            LinkedHashMap map = (LinkedHashMap) responseEntity.getBody().getContent();
            cashBanksLOV = Optional.of(halMapper.processEntity(map,CashBanksLOV.class));
        }

        return ResponseUtil.wrapOrNotFound(cashBanksLOV);
    }

    /**
     * {@code DELETE  /cash-banks-lovs/:id} : delete the "id" cashBanksLOV.
     *
     * @param id the id of the cashBanksLOV to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cash-banks-lovs/{id}")
    public ResponseEntity<Void> deleteCashBanksLOV(@PathVariable Long id) {
        log.debug("REST request to delete CashBanksLOV : {}", id);
        // cashBanksLOVRepository.deleteById(id);
        return ResponseEntity.noContent().headers(
            HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())
        ).build();
    }
}
