package ru.otus.spring.oca.web.rest;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.otus.spring.oca.domain.CashBanksLOV;
import ru.otus.spring.oca.domain.StandardReceipt;
import ru.otus.spring.oca.service.mapper.HalMapper;
import ru.otus.spring.oca.service.Utils;
import ru.otus.spring.oca.service.mapper.JsonViews;
import ru.otus.spring.oca.web.rest.errors.BadRequestAlertException;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * VL
 * REST controller for managing {@link ru.otus.spring.oca.domain.StandardReceipt}.
 */
@RestController
@RequestMapping("/api")
public class StandardReceiptResource {

    private final Logger log = LoggerFactory.getLogger(StandardReceiptResource.class);

    private static final String ENTITY_NAME = "standardReceipt";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final String RESTAPIURL;
    private RestTemplate restTemplate;
    private HalMapper<StandardReceipt> halMapper;

    public StandardReceiptResource (
        // @Value("${application.urls.ServerUrl}") String serverUrl,
        // @Value("${application.urls.StandardReceiptsUrl}") String standardReceiptsUrl,
        RestTemplate restTemplate,
        HalMapper<StandardReceipt> halMapper
    ) {
        // this.RESTAPIURL = serverUrl + standardReceiptsUrl;
        this.RESTAPIURL = "https://egxt-dev4.fa.em2.oraclecloud.com" +
            "/fscmRestApi/resources/11.13.18.05/standardReceipts";
        this.restTemplate = restTemplate;
        this.halMapper = halMapper;
    }

    /**
     * {@code POST  /standard-receipts} : Create a new standardReceipt.
     *
     * @param standardReceipt the standardReceipt to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new standardReceipt, or with status {@code 400 (Bad Request)} if the standardReceipt has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/standard-receipts")
    public ResponseEntity<StandardReceipt> createStandardReceipt(@RequestBody StandardReceipt standardReceipt) throws URISyntaxException, JsonProcessingException {
        log.debug("REST request to save StandardReceipt : {}", standardReceipt);
        if (standardReceipt.getStandardReceiptId() != null) {
            throw new BadRequestAlertException("A new standardReceipt cannot already have an ID", ENTITY_NAME, "idexists");
        }

        standardReceipt.setStandardReceiptId(null);
        standardReceipt.setReceiptNumber("XXVL: "+standardReceipt.getReceiptNumber());
        standardReceipt.setComments("XXVL");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(standardReceipt);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(json, headers);
        System.out.println("XXX: " + request);

        StandardReceipt result =
            restTemplate.postForObject(RESTAPIURL, request, StandardReceipt.class);

        return ResponseEntity.created(new URI("/api/standard-receipts/" + result.getStandardReceiptId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getStandardReceiptId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /standard-receipts} : Updates an existing standardReceipt.
     *
     * @param standardReceipt the standardReceipt to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated standardReceipt,
     * or with status {@code 400 (Bad Request)} if the standardReceipt is not valid,
     * or with status {@code 500 (Internal Server Error)} if the standardReceipt couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    // Метод используется для тестового создания поступления, чтобы не перебивать значения полей
    @PutMapping("/standard-receipts")
    public ResponseEntity<StandardReceipt> updateStandardReceipt(@RequestBody StandardReceipt standardReceipt) throws URISyntaxException, JsonProcessingException, ParseException {
        log.debug("REST request to update StandardReceipt : {}", standardReceipt);
        if (standardReceipt.getStandardReceiptId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        standardReceipt.setStandardReceiptId(null);
        standardReceipt.setReceiptNumber("XXVL: "+standardReceipt.getReceiptNumber());
        standardReceipt.setDocumentNumber(null);
        standardReceipt.setComments("XXVL");
        // standardReceipt.setReceiptDate(new SimpleDateFormat("dd/MM/yyyy").parse("20/05/2020"));
//        standardReceipt.setReceiptDate(new SimpleDateFormat("dd/MM/yyyy").parse("20/05/2020"));
//        standardReceipt.setAccountingDate(new SimpleDateFormat("dd/MM/yyyy").parse("20/05/2020"));
        standardReceipt.setReceiptDate(new Date());
        standardReceipt.setAccountingDate(new Date());
        standardReceipt.setReceiptMethod("RUH001 D-HSBC RUB MAIN 100268");
        standardReceipt.setRemittanceBankAccountNumber("40702810000000100268");
        standardReceipt.setRemittanceBankName("ООО \"ЭЙЧ-ЭС-БИ-СИ БАНК (РР)\"");
        standardReceipt.setRemittanceBankBranch("000");
        standardReceipt.setRemittanceBankDepositDate(null);
        // standardReceipt.setAccountingDate(null);
        standardReceipt.setMaturityDate(null);
        standardReceipt.setCreatedBy(null);
        standardReceipt.setCreationDate(null);
        standardReceipt.setLastUpdateDate(null);
        standardReceipt.setLastUpdatedBy(null);
        standardReceipt.setState(null);
        standardReceipt.setStatus(null);

        // {"StandardReceiptId":null,"ReceiptNumber":"XXVL: 00000000289","BusinessUnit":"RU01_BU","ReceiptMethod":"RUH001 D-HSBC RUB MAIN 100268","ReceiptDate":"2020-05-19","DocumentNumber":null,"Amount":38400.0,"Currency":"RUB","ConversionRateType":null,"ConversionDate":null,"ConversionRate":null,"RemittanceBankAccountNumber":"40702810000000100268","RemittanceBankDepositDate":null,"RemittanceBankAllowOverride":"Y","CustomerName":"Чигоев Александр Георгиевич ИП","CustomerSite":"44108","CustomerAccountNumber":"C70000015","Comments":"XXVL"}

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.ALL));
        headers.set("Accept-Encoding","gzip, deflate, br");
        headers.set("Connection", "keep-alive");
        headers.setBearerAuth("eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsIng1dCI6Il9pajZSRWNqaFZNTHRKemZMMUVPWEJzS0ZadyIsImtpZCI6InRydXN0c2VydmljZSJ9.eyJleHAiOjE1OTAwMjM5NDksInN1YiI6InYubHl1bGluQHBhcnRuZXIuYXVjaGFuLnJ1IiwiaXNzIjoid3d3Lm9yYWNsZS5jb20iLCJwcm4iOiJ2Lmx5dWxpbkBwYXJ0bmVyLmF1Y2hhbi5ydSIsImlhdCI6MTU5MDAwOTU0OX0.NgNtIoVNL2havjMNUyG5y6rgrYwJ0xBp6DfQBb45uY3z4x2YylZDtwjl5uAo2KUdZB8PbQNjR7Nn29mmmicPBM0sA4PRxLNEiQt0xfmZnXhklZBaIEK6tOqeHGa9o4fz0WIOkqkbhjrK9QG_1A7WB1Yd4MdNXp6E6lui3dYWhu4FiL5oBmyU3qxtRzSXLG83X5GeD5HUY_KxspQMI15qKNxrw8NIku39tV1Pr8Og18RLFVBgczxnw-bO8NBczo3LZOX6fcUS4gyrPMRh1VzezYg_eoe2N-cijzy-dZvBSHcwbVNq4AaqFST3SQA0VSPd6QuTpD7hcWEiyOq7HIK9-Q");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
        String json = mapper
            .writerWithView(JsonViews.StandardReceiptCreateView.class)
            .writeValueAsString(standardReceipt);
        HttpEntity<String> entity = new HttpEntity<>(json,headers);

        ResponseEntity<String> response = restTemplate.postForEntity(RESTAPIURL,entity,String.class);

        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName,
                false,
                ENTITY_NAME,
                standardReceipt.getStandardReceiptId().toString()))
            .body(null);
    }

    /**
     * {@code GET  /standard-receipts} : get all the standardReceipts.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of standardReceipts in body.
     */
    @GetMapping("/standard-receipts")
    public ResponseEntity<List<StandardReceipt>> getAllStandardReceipts(
        @RequestParam(value = "q", name = "q", required = false) String q,
        Pageable pageable)
    {
        log.debug("REST request to get a page of StandardReceipts");

        int offset = pageable.getPageNumber();
        int limit = pageable.getPageSize();

        String ServiceURL = Utils.getServiceURL(RESTAPIURL,q,offset,limit);
        System.out.println("XXX ServiceURL: "+ServiceURL);
        ResponseEntity<EntityModel<Map<String,StandardReceipt[]>>> responseEntity =
            restTemplate.exchange(ServiceURL, HttpMethod.GET, null,
                new TypeReferences.EntityModelType<Map<String,StandardReceipt[]>>() {},
                Collections.emptyMap());

        List<StandardReceipt> all =
            halMapper.process((LinkedHashMap)responseEntity.getBody().getContent(), StandardReceipt.class);

        Page<StandardReceipt> page = new PageImpl<>(all, pageable, all.size());
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /standard-receipts/:id} : get the "id" standardReceipt.
     *
     * @param id the id of the standardReceipt to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the standardReceipt, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/standard-receipts/{id}")
    public ResponseEntity<StandardReceipt> getStandardReceipt(@PathVariable Long id) {
        log.debug("REST request to get StandardReceipt : {}", id);

        String URL = RESTAPIURL + "/" + id;

        ResponseEntity<EntityModel<Map<String,StandardReceipt>>> responseEntity =
            restTemplate.exchange(URL, HttpMethod.GET, null,
                new TypeReferences.EntityModelType<Map<String,StandardReceipt>>() {},
                Collections.emptyMap());

        Optional<StandardReceipt> standardReceipt = Optional.empty();
        if(responseEntity.getStatusCode() == HttpStatus.OK) {
            LinkedHashMap map = (LinkedHashMap) responseEntity.getBody().getContent();
            standardReceipt = Optional.of(halMapper.processEntity(map, StandardReceipt.class));
        }
        return ResponseUtil.wrapOrNotFound(standardReceipt);
    }

    /**
     * {@code DELETE  /standard-receipts/:id} : delete the "id" standardReceipt.
     *
     * @param id the id of the standardReceipt to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/standard-receipts/{id}")
    public ResponseEntity<Void> deleteStandardReceipt(@PathVariable Long id) {
        log.debug("REST request to delete StandardReceipt : {}", id);
        // Нет операции удаления
        // standardReceiptRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
