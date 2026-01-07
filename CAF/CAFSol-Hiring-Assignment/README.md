# CAFSol'S ASSIGNMENT 

This repository contains two Spring Boot assignments implemented using Java and Maven.

---

## Assignment 1: Config Reader Service

### Description
Reads a custom configuration file with multiple sections and stores the data
in memory for fast access. Provides a REST API to fetch configuration
details by section name.

### Features
- Custom config file parsing
- Section-wise data storage
- REST API returning JSON
- Spring Boot + Maven
- Unit tests included

### Example API
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


## Assignment 2: Price Service

### Description
Reads pricing offers from a TSV file and returns price based on SKU ID and time.

### Features
- TSV file upload
- In-memory fast lookup using HashMap
- Time-based price selection
- Handles overlapping offers
- REST APIs
- Unit tests included

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

## Technologies Used
- Java 17
- Spring Boot
- Maven

## Author
- NAME- RIMI PAUL
