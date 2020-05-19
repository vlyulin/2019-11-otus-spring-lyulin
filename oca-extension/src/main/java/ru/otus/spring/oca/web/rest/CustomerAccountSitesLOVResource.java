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
import ru.otus.spring.oca.domain.CashBankAccountsLOV;
import ru.otus.spring.oca.domain.CustomerAccountSitesLOV;
import ru.otus.spring.oca.service.mapper.HalMapper;
import ru.otus.spring.oca.service.Utils;
import ru.otus.spring.oca.web.rest.errors.BadRequestAlertException;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * REST controller for managing {@link ru.otus.spring.oca.domain.CustomerAccountSitesLOV}.
 */
@RestController
@RequestMapping("/api")
public class CustomerAccountSitesLOVResource {

    private final Logger log = LoggerFactory.getLogger(CustomerAccountSitesLOVResource.class);

    private static final String ENTITY_NAME = "customerAccountSitesLOV";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final String RESTAPIURL;
    private RestTemplate restTemplate;
    private HalMapper<CustomerAccountSitesLOV> halMapper;

    public CustomerAccountSitesLOVResource(
        RestTemplate restTemplate,
        HalMapper<CustomerAccountSitesLOV> halMapper
    ) {
        this.RESTAPIURL = "https://egxt-dev4.fa.em2.oraclecloud.com" +
            "/fscmRestApi/resources/11.13.18.05/customerAccountSitesLOV";
        this.restTemplate = restTemplate;
        this.halMapper = halMapper;
    }

    /**
     * {@code POST  /customer-account-sites-lovs} : Create a new customerAccountSitesLOV.
     *
     * @param customerAccountSitesLOV the customerAccountSitesLOV to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new customerAccountSitesLOV, or with status {@code 400 (Bad Request)} if the customerAccountSitesLOV has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/customer-account-sites-lovs")
    public ResponseEntity<CustomerAccountSitesLOV> createCustomerAccountSitesLOV(
        @RequestBody CustomerAccountSitesLOV customerAccountSitesLOV) throws URISyntaxException
    {
        log.debug("REST request to save CustomerAccountSitesLOV : {}", customerAccountSitesLOV);
        if (customerAccountSitesLOV.getCustomerAccountId() != null) {
            throw new BadRequestAlertException("A new customerAccountSitesLOV cannot already have an ID", ENTITY_NAME, "idexists");
        }
        // TODO: Сделать
        CustomerAccountSitesLOV result = null; // customerAccountSitesLOVRepository.save(customerAccountSitesLOV);
        return ResponseEntity.created(new URI("/api/customer-account-sites-lovs/" + result.getCustomerAccountId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName,
                false,
                ENTITY_NAME,
                result.getCustomerAccountId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /customer-account-sites-lovs} : Updates an existing customerAccountSitesLOV.
     *
     * @param customerAccountSitesLOV the customerAccountSitesLOV to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated customerAccountSitesLOV,
     * or with status {@code 400 (Bad Request)} if the customerAccountSitesLOV is not valid,
     * or with status {@code 500 (Internal Server Error)} if the customerAccountSitesLOV couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/customer-account-sites-lovs")
    public ResponseEntity<CustomerAccountSitesLOV> updateCustomerAccountSitesLOV(@RequestBody CustomerAccountSitesLOV customerAccountSitesLOV) throws URISyntaxException {
        log.debug("REST request to update CustomerAccountSitesLOV : {}", customerAccountSitesLOV);
        if (customerAccountSitesLOV.getCustomerAccountId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        // TODO: Сделать
        CustomerAccountSitesLOV result = null; // customerAccountSitesLOVRepository.save(customerAccountSitesLOV);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName,
                false,
                ENTITY_NAME,
                customerAccountSitesLOV.getCustomerAccountId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /customer-account-sites-lovs} : get all the customerAccountSitesLOVS.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of customerAccountSitesLOVS in body.
     */
    @GetMapping("/customer-account-sites-lovs")
    public ResponseEntity<List<CustomerAccountSitesLOV>> getAllCustomerAccountSitesLOVS(Pageable pageable) {
        log.debug("REST request to get a page of CustomerAccountSitesLOVS");

        int offset = pageable.getPageNumber();
        int limit = pageable.getPageSize();
        // TODO: ?q - доавить
        String ServiceURL = Utils.getServiceURL(RESTAPIURL,"",offset,limit);

        ResponseEntity<EntityModel<Map<String, CustomerAccountSitesLOV[]>>> responseEntity =
            restTemplate.exchange(ServiceURL, HttpMethod.GET, null,
                new TypeReferences.EntityModelType<Map<String,CustomerAccountSitesLOV[]>>() {},
                Collections.emptyMap());

        List<CustomerAccountSitesLOV> all = halMapper.process(
            (LinkedHashMap)responseEntity.getBody().getContent(), CustomerAccountSitesLOV.class);

        Page<CustomerAccountSitesLOV> page = new PageImpl<>(all, pageable, all.size());
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /customer-account-sites-lovs/:id} : get the "id" customerAccountSitesLOV.
     *
     * @param id the id of the customerAccountSitesLOV to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the customerAccountSitesLOV, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/customer-account-sites-lovs/{id}")
    public ResponseEntity<CustomerAccountSitesLOV> getCustomerAccountSitesLOV(@PathVariable Long id) {
        log.debug("REST request to get CustomerAccountSitesLOV : {}", id);

        String URL = RESTAPIURL + "/" + id;

        ResponseEntity<EntityModel<Map<String, CustomerAccountSitesLOV>>> responseEntity =
            restTemplate.exchange(URL, HttpMethod.GET, null,
                new TypeReferences.EntityModelType<Map<String,CustomerAccountSitesLOV>>() {},
                Collections.emptyMap());

        Optional<CustomerAccountSitesLOV> customerAccountSitesLOV = Optional.empty();
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            LinkedHashMap map = (LinkedHashMap) responseEntity.getBody().getContent();
            customerAccountSitesLOV = Optional.of(halMapper.processEntity(map,CustomerAccountSitesLOV.class));
        }

        return ResponseUtil.wrapOrNotFound(customerAccountSitesLOV);
    }

    /**
     * {@code DELETE  /customer-account-sites-lovs/:id} : delete the "id" customerAccountSitesLOV.
     *
     * @param id the id of the customerAccountSitesLOV to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/customer-account-sites-lovs/{id}")
    public ResponseEntity<Void> deleteCustomerAccountSitesLOV(@PathVariable Long id) {
        log.debug("REST request to delete CustomerAccountSitesLOV : {}", id);
        // customerAccountSitesLOVRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
