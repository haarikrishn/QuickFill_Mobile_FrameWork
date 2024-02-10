package com.DmartLabs.commonutils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GSheet {
    private final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private final String CREDENTIALS_FILE_PATH = "/credentials.json";

    private Sheets service;
    private final String spreadsheetId;

    public GSheet(String sheetId) throws GeneralSecurityException, IOException {
        this.spreadsheetId = sheetId;
        this.setSheets();
    }

    private void setSheets() throws GeneralSecurityException, IOException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        this.service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    /**
     * Creates an authorized Credential object.
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = GSheet.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public String getCellValue(String sheetName, int row, String colName) throws IOException {
        //Sheet1!A4:A4
        //Sheet1!A2:D5
        String range =  sheetName + "!" + colName + row +":" +row;
        ValueRange response = service.spreadsheets().values()
                .get(this.spreadsheetId, range)
                .execute();

        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
            return  "";
        } else {
            return values.get(0).get(0).toString();
        }
    }

    public void setCellValue(String sheetName, int row, String colName, String value) throws IOException {

        List<List<Object>> values = Arrays.asList(Arrays.asList(value));

        //Sheet1!A4:A4
        //Sheet1!A2:D5
        String range =  sheetName + "!" + colName + row +":" +row;
        ValueRange body = new ValueRange()
                .setValues(values);
        UpdateValuesResponse result =
                service.spreadsheets().values().update(spreadsheetId, range, body)
                        .setValueInputOption("RAW")
                        .execute();
        System.out.printf("%d cells updated.", result.getUpdatedCells());
    }

    /** Unit Test **/
    public static void main(String[] args) throws GeneralSecurityException, IOException {
        GSheet gSheetUtils = new GSheet("1pPkZ3wZNBMfMTJVFse7Aer_9eaw2Lmhbn2sU3Akoj9E");
        String value = gSheetUtils.getCellValue("Sheet1", 3,"C");
        System.out.println("Value: " + value);

        gSheetUtils.setCellValue("Sheet1", 3, "C", "Hello Qualitrix");
    }

}
