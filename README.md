# CAFSol'S ASSIGNMENT 

## ASSIGNMENT 1- Config-Reader-Service 

### Project Description
This project is a beginner-friendly Spring Boot application
that reads a custom configuration text file containing
multiple service sections and their properties.
Each section is parsed and stored in memory for quick access.

The application exposes a REST API that allows users
to request configuration details by providing a section name.

### Input File Structure
The configuration file contains:
- Section headers (example: Gateway, Order Service)
- Key-value pairs under each section

Multiple values (like topics) are separated by commas
and returned as arrays in the API response.

### Key Functionalities
- Reads and parses configuration file at startup
- Stores section-wise configuration in memory
- Converts comma-separated values into lists
- Returns configuration in JSON format via REST API

### Example 
Save the below content in a file

    '''' START '''''

    Gateway
    endpoint = https://xyz.in
    certurl = https://cloud.internalportal.com
    download loc =  /home/user/temp

    CXO
    endpont = http://internal.cxo.com
    redirect url = 
    broker = http://cxobroker.in
    topic = test_cxo_topic, test_cxo_topic_1 

    Order Service
    broker = https://orbroker.in
    topic = test_os_topic_1, test_os_topic_2

    '''' END ''''

### Response
    
    {
     "topic": [
       "test_os_topic_1",
       "test_os_topic_2"
     ],
    "broker": "https://orbroker.in"
    }


## ASSIGNMENT 2 - PriceService

### Project Description
This Spring Boot application processes a TSV (Tab-Separated Values)
file containing SKU-based pricing information with time ranges.
The system determines the correct price based on SKU ID
and an optional time provided by the user.

When multiple price ranges overlap, the price that matches
the given time range is returned.

### Application Capabilities
- Reads TSV pricing file
- Stores pricing data efficiently in memory
- Supports fast price lookup
- Handles overlapping time windows correctly
- Returns "NOT SET" when no price is applicable

### What This Project Demonstrates
- TSV file parsing
- Time comparison logic
- Query parameter handling
- Business rule implementation
- Test-driven development basics

### Example
Save the below content as a TSV file

    SkuID | StartTime | EndTime | Price
    u00006541|10:00|10:15|101
    i00006111|10:02| 10:05|100
    u09099000 | 10:00|10:08|5000
    t12182868| 10:00| 20:00|87
    b98989000| 00:30| 7:00|9128
    u00006541|10:05|10:10|99
    t12182868| 14:00| 15:00|92

### Response
     - time = 09:54 = NOT SET
     - time = 10:03 = 101
     - time = 10:05 = 99.....


## Technology Used
- Java 17
- Spring Boot
- Maven
- REST APIs

## Developer
Name - RIMI PAUL 

