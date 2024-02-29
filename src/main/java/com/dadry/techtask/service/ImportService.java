package com.dadry.techtask.service;

import com.dadry.techtask.entity.AsinReport;
import com.dadry.techtask.entity.DateReport;
import com.dadry.techtask.entity.Report;
import com.dadry.techtask.repository.AsinReportRepository;
import com.dadry.techtask.repository.DateReportRepository;
import com.dadry.techtask.utils.LocalDateTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class ImportService {
    @Value("${report.file.path}")
    private String reportFilePath;

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");

    private final DateReportRepository dateReportRepository;
    private final AsinReportRepository asinReportRepository;

    public void importReportData() {
        try {
            Report report = readJsonFile();
            if (Objects.isNull(report)) {
                return;
            }
            for (DateReport dateReport : report.getSalesAndTrafficByDate()) {
                dateReport.setId(dateReport.getDate().format(DATE_FORMATTER));
                dateReportRepository.save(dateReport);
            }
            for (AsinReport asinReport : report.getSalesAndTrafficByAsin()) {
                asinReport.setId(asinReport.getParentAsin());
                asinReportRepository.save(asinReport);
            }
            renameFile();
            log.info("Report file was imported successfully!");
        } catch (Exception e) {
            log.error("Can't write date to mongoDB!", e);
        }
    }

    private Report readJsonFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(reportFilePath))) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                    .setDateFormat(DATE_FORMAT)
                    .create();
            return gson.fromJson(bufferedReader, Report.class);
        } catch (FileNotFoundException e) {
            log.info("There is no file {} to process!", reportFilePath);
        } catch (IOException e) {
            log.error("Can't process the export file!", e);
        }
        return null;
    }

    private void renameFile() throws IOException {
        File oldFile = new File(reportFilePath);
        StringBuilder sb = new StringBuilder(LocalDateTime.now().format(DATE_TIME_FORMATTER));
        sb.append(".json");
        File newFile = new File(oldFile.getParent(), sb.toString());
        Files.move(oldFile.toPath(), newFile.toPath());
    }
}
