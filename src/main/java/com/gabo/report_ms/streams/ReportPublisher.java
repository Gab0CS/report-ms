package com.gabo.report_ms.streams;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ReportPublisher {

    private final StreamBridge streamBridge;

    /*
     * Topic name -> consumerReport
     */
    public void publishReport(String report){
        this.streamBridge.send("consumerReport", report);
        this.streamBridge.send("consumerReport-in-0", report);
        this.streamBridge.send("consumerReport-out-0", report);
    }
}
