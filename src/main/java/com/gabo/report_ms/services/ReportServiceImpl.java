package com.gabo.report_ms.services;

import org.springframework.stereotype.Service;

import com.gabo.report_ms.repositories.CompaniesRepository;
import com.netflix.discovery.EurekaClient;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {

    private final CompaniesRepository companiesRepository;


    @Override
    public String makeReport(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeReport'");
    }

    @Override
    public String saveReport(String nameReport) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveReport'");
    }

    @Override
    public void deleteReport(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteReport'");
    }
    
}
