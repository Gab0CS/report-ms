package com.gabo.report_ms.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.gabo.report_ms.helper.ReportHelper;
import com.gabo.report_ms.models.Company;
import com.gabo.report_ms.models.WebSite;
import com.gabo.report_ms.repositories.CompaniesRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {

    private final CompaniesRepository companiesRepository;
    private final ReportHelper reportHelper;

    @Override
    public String makeReport(String name) {
        return reportHelper.readTemplate(this.companiesRepository.getByName(name).orElseThrow());

    }

    @Override
    public String saveReport(String report) {
        var format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        var placeholders = this.reportHelper.getPlaceHolderFromTemplate(report);
        List<WebSite> webSites = Stream.of(placeholders.get(3))
        .map(website -> WebSite.builder().name(website).build())
        .toList();

        var company = Company.builder()
        .name(placeholders.get(0))
        .foundationDate(LocalDate.parse(placeholders.get(1), format))
        .founder(placeholders.get(2))
        .webSites(webSites)
        .build();

        this.companiesRepository.postByName(company);
        return "Saved";
    }

    @Override
    public void deleteReport(String name) {
        this.companiesRepository.deleteByName(name);
    }
    
}
