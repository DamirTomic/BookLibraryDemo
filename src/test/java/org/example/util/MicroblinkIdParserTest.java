package org.example.util;

import org.example.model.User;

import static org.junit.jupiter.api.Assertions.*;

class MicroblinkIdParserTest
{
    @org.junit.jupiter.api.Test
    void test_rawMrzParse()
    {
        MicroblinkIdParser microblinkIdParser = new MicroblinkIdParser();
        User testUser = microblinkIdParser.parseResponse(json);
        assertNotNull(testUser);
        assertEquals("791125",testUser.getDateOfBirth());
        assertEquals("SPECIMEN DRUGO",testUser.getFirstName());
        assertEquals("ANABANAN",testUser.getLastName());
        assertTrue(testUser.isDoBValid());
    }

    @org.junit.jupiter.api.Test
    void test_imageProcessingAPI()
    {
        MicroblinkIdParser microblinkIdParser = new MicroblinkIdParser();
        User testUser = microblinkIdParser.getUserDetails("https://upload.wikimedia.org/wikipedia/commons/thumb/1/10/New_Croatian_ID_Card_%28Backside%29_%282021%29.jpg/190px-New_Croatian_ID_Card_%28Backside%29_%282021%29.jpg");
        assertNotNull(testUser);
        assertEquals("791125",testUser.getDateOfBirth());
        assertEquals("SPECIMEN",testUser.getFirstName());
        assertEquals("SPECIMEN",testUser.getLastName());
        assertTrue(testUser.isDoBValid());
    }

    private final String json = "{\n" +
            "    \"executionId\": \"9b2c62c0-a5fa-4376-ba07-8c7b95af7c74\",\n" +
            "    \"finishTime\": \"2022-09-18T12:48:58.283Z\",\n" +
            "    \"startTime\": \"2022-09-18T12:48:58.201Z\",\n" +
            "    \"result\": {\n" +
            "        \"dateOfBirth\": {\n" +
            "            \"day\": 25,\n" +
            "            \"month\": 11,\n" +
            "            \"year\": 1979,\n" +
            "            \"successfullyParsed\": true,\n" +
            "            \"originalString\": \"791125\"\n" +
            "        },\n" +
            "        \"classInfo\": {\n" +
            "            \"country\": \"COUNTRY_CROATIA\",\n" +
            "            \"region\": \"REGION_NONE\",\n" +
            "            \"type\": \"TYPE_ID\",\n" +
            "            \"countryName\": \"CROATIA\",\n" +
            "            \"isoAlpha3CountryCode\": \"HRV\",\n" +
            "            \"isoAlpha2CountryCode\": \"HR\",\n" +
            "            \"isoNumericCountryCode\": \"191\"\n" +
            "        },\n" +
            "        \"type\": \"MRTD\",\n" +
            "        \"isBelowAgeLimit\": false,\n" +
            "        \"age\": 42,\n" +
            "        \"recognitionStatus\": \"VALID\",\n" +
            "        \"firstName\": \"SPECIMEN\",\n" +
            "        \"lastName\": \"SPECIMEN\",\n" +
            "        \"fullName\": \"\",\n" +
            "        \"address\": \"\",\n" +
            "        \"dateOfIssue\": {\n" +
            "            \"day\": 0,\n" +
            "            \"month\": 0,\n" +
            "            \"year\": 0,\n" +
            "            \"successfullyParsed\": false,\n" +
            "            \"originalString\": \"\"\n" +
            "        },\n" +
            "        \"dateOfExpiry\": {\n" +
            "            \"day\": 2,\n" +
            "            \"month\": 8,\n" +
            "            \"year\": 2026,\n" +
            "            \"successfullyParsed\": true,\n" +
            "            \"originalString\": \"260802\"\n" +
            "        },\n" +
            "        \"documentNumber\": \"115501830\",\n" +
            "        \"sex\": \"F\",\n" +
            "        \"driverLicenseDetailedInfo\": {\n" +
            "            \"restrictions\": \"\",\n" +
            "            \"endorsements\": \"\",\n" +
            "            \"vehicleClass\": \"\",\n" +
            "            \"conditions\": \"\",\n" +
            "            \"vehicleClassesInfo\": []\n" +
            "        },\n" +
            "        \"fullDocumentImageBase64\": \"\",\n" +
            "        \"faceImageBase64\": \"\",\n" +
            "        \"additionalNameInformation\": \"\",\n" +
            "        \"additionalAddressInformation\": \"\",\n" +
            "        \"additionalOptionalAddressInformation\": \"\",\n" +
            "        \"placeOfBirth\": \"\",\n" +
            "        \"nationality\": \"CROATIAN\",\n" +
            "        \"race\": \"\",\n" +
            "        \"religion\": \"\",\n" +
            "        \"profession\": \"\",\n" +
            "        \"maritalStatus\": \"\",\n" +
            "        \"residentialStatus\": \"\",\n" +
            "        \"employer\": \"\",\n" +
            "        \"personalIdNumber\": \"\",\n" +
            "        \"documentAdditionalNumber\": \"\",\n" +
            "        \"documentOptionalAdditionalNumber\": \"\",\n" +
            "        \"issuingAuthority\": \"\",\n" +
            "        \"mrzData\": {\n" +
            "            \"rawMrzString\": \"IOHRV115501830605781305459<<<<\\n7911255F2608020HRV<<<<<<<<<<<5\\nANABANAN<<SPECIMEN<DRUGO<<<<<<\\n\",\n" +
            "            \"documentCode\": \"IO\",\n" +
            "            \"issuer\": \"HRV\",\n" +
            "            \"documentNumber\": \"115501830\",\n" +
            "            \"opt1\": \"05781305459\",\n" +
            "            \"opt2\": \"\",\n" +
            "            \"gender\": \"F\",\n" +
            "            \"nationality\": \"HRV\",\n" +
            "            \"primaryId\": \"SPECIMEN\",\n" +
            "            \"secondaryId\": \"SPECIMEN\",\n" +
            "            \"alienNumber\": \"\",\n" +
            "            \"applicationReceiptNumber\": \"\",\n" +
            "            \"immigrantCaseNumber\": \"\",\n" +
            "            \"mrzVerified\": true,\n" +
            "            \"mrzParsed\": true,\n" +
            "            \"dateOfBirth\": {\n" +
            "                \"day\": 25,\n" +
            "                \"month\": 11,\n" +
            "                \"year\": 1979,\n" +
            "                \"successfullyParsed\": true,\n" +
            "                \"originalString\": \"791125\"\n" +
            "            },\n" +
            "            \"dateOfExpiry\": {\n" +
            "                \"day\": 2,\n" +
            "                \"month\": 8,\n" +
            "                \"year\": 2026,\n" +
            "                \"successfullyParsed\": true,\n" +
            "                \"originalString\": \"260802\"\n" +
            "            },\n" +
            "            \"documentType\": \"IDENTITY_CARD\",\n" +
            "            \"issuerName\": \"CROATIA\",\n" +
            "            \"nationalityName\": \"CROATIAN\"\n" +
            "        },\n" +
            "        \"conditions\": \"\",\n" +
            "        \"localizedName\": \"\",\n" +
            "        \"dateOfExpiryPermanent\": false,\n" +
            "        \"additionalPersonalIdNumber\": \"\",\n" +
            "        \"viz\": {\n" +
            "            \"firstName\": \"\",\n" +
            "            \"lastName\": \"\",\n" +
            "            \"fullName\": \"\",\n" +
            "            \"additionalNameInformation\": \"\",\n" +
            "            \"localizedName\": \"\",\n" +
            "            \"address\": \"\",\n" +
            "            \"additionalAddressInformation\": \"\",\n" +
            "            \"additionalOptionalAddressInformation\": \"\",\n" +
            "            \"placeOfBirth\": \"\",\n" +
            "            \"nationality\": \"\",\n" +
            "            \"race\": \"\",\n" +
            "            \"religion\": \"\",\n" +
            "            \"profession\": \"\",\n" +
            "            \"maritalStatus\": \"\",\n" +
            "            \"residentialStatus\": \"\",\n" +
            "            \"employer\": \"\",\n" +
            "            \"sex\": \"\",\n" +
            "            \"dateOfBirth\": {\n" +
            "                \"day\": 0,\n" +
            "                \"month\": 0,\n" +
            "                \"year\": 0,\n" +
            "                \"successfullyParsed\": false,\n" +
            "                \"originalString\": \"\"\n" +
            "            },\n" +
            "            \"dateOfIssue\": {\n" +
            "                \"day\": 0,\n" +
            "                \"month\": 0,\n" +
            "                \"year\": 0,\n" +
            "                \"successfullyParsed\": false,\n" +
            "                \"originalString\": \"\"\n" +
            "            },\n" +
            "            \"dateOfExpiry\": {\n" +
            "                \"day\": 0,\n" +
            "                \"month\": 0,\n" +
            "                \"year\": 0,\n" +
            "                \"successfullyParsed\": false,\n" +
            "                \"originalString\": \"\"\n" +
            "            },\n" +
            "            \"dateOfExpiryPermanent\": false,\n" +
            "            \"documentNumber\": \"\",\n" +
            "            \"personalIdNumber\": \"\",\n" +
            "            \"documentAdditionalNumber\": \"\",\n" +
            "            \"additionalPersonalIdNumber\": \"\",\n" +
            "            \"documentOptionalAdditionalNumber\": \"\",\n" +
            "            \"issuingAuthority\": \"\",\n" +
            "            \"driverLicenseDetailedInfo\": {\n" +
            "                \"restrictions\": \"\",\n" +
            "                \"endorsements\": \"\",\n" +
            "                \"vehicleClass\": \"\",\n" +
            "                \"conditions\": \"\",\n" +
            "                \"vehicleClassesInfo\": []\n" +
            "            },\n" +
            "            \"conditions\": \"\",\n" +
            "            \"fathersName\": \"\",\n" +
            "            \"mothersName\": \"\"\n" +
            "        },\n" +
            "        \"barcode\": {\n" +
            "            \"rawDataBase64\": \"\",\n" +
            "            \"stringData\": \"\",\n" +
            "            \"firstName\": \"\",\n" +
            "            \"lastName\": \"\",\n" +
            "            \"middleName\": \"\",\n" +
            "            \"fullName\": \"\",\n" +
            "            \"additionalNameInformation\": \"\",\n" +
            "            \"address\": \"\",\n" +
            "            \"placeOfBirth\": \"\",\n" +
            "            \"nationality\": \"\",\n" +
            "            \"race\": \"\",\n" +
            "            \"religion\": \"\",\n" +
            "            \"profession\": \"\",\n" +
            "            \"maritalStatus\": \"\",\n" +
            "            \"residentialStatus\": \"\",\n" +
            "            \"employer\": \"\",\n" +
            "            \"sex\": \"\",\n" +
            "            \"dateOfBirth\": {\n" +
            "                \"day\": 0,\n" +
            "                \"month\": 0,\n" +
            "                \"year\": 0,\n" +
            "                \"successfullyParsed\": false,\n" +
            "                \"originalString\": \"\"\n" +
            "            },\n" +
            "            \"dateOfIssue\": {\n" +
            "                \"day\": 0,\n" +
            "                \"month\": 0,\n" +
            "                \"year\": 0,\n" +
            "                \"successfullyParsed\": false,\n" +
            "                \"originalString\": \"\"\n" +
            "            },\n" +
            "            \"dateOfExpiry\": {\n" +
            "                \"day\": 0,\n" +
            "                \"month\": 0,\n" +
            "                \"year\": 0,\n" +
            "                \"successfullyParsed\": false,\n" +
            "                \"originalString\": \"\"\n" +
            "            },\n" +
            "            \"documentNumber\": \"\",\n" +
            "            \"personalIdNumber\": \"\",\n" +
            "            \"documentAdditionalNumber\": \"\",\n" +
            "            \"issuingAuthority\": \"\",\n" +
            "            \"addressDetailedInfo\": {\n" +
            "                \"street\": \"\",\n" +
            "                \"postalCode\": \"\",\n" +
            "                \"city\": \"\",\n" +
            "                \"jurisdiction\": \"\"\n" +
            "            },\n" +
            "            \"driverLicenseDetailedInfo\": {\n" +
            "                \"restrictions\": \"\",\n" +
            "                \"endorsements\": \"\",\n" +
            "                \"vehicleClass\": \"\",\n" +
            "                \"conditions\": \"\",\n" +
            "                \"vehicleClassesInfo\": []\n" +
            "            },\n" +
            "            \"extendedElements\": []\n" +
            "        },\n" +
            "        \"imageAnalysisResult\": {\n" +
            "            \"blurred\": true,\n" +
            "            \"documentImageColorStatus\": \"COLOR\",\n" +
            "            \"documentImageMoireStatus\": \"NOT_AVAILABLE\",\n" +
            "            \"faceDetectionStatus\": \"NOT_DETECTED\",\n" +
            "            \"mrzDetectionStatus\": \"DETECTED\",\n" +
            "            \"barcodeDetectionStatus\": \"NOT_DETECTED\"\n" +
            "        },\n" +
            "        \"processingStatus\": \"SUCCESS\",\n" +
            "        \"recognitionMode\": \"MRZ_ID\",\n" +
            "        \"signatureImageBase64\": \"\",\n" +
            "        \"fathersName\": \"\",\n" +
            "        \"mothersName\": \"\"\n" +
            "    }\n" +
            "}";

}