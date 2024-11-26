# VirtualThreads

- https://www.infoworld.com/article/3678148/intro-to-virtual-threads-a-new-approach-to-java-concurrency.html

<!---
Digital Onboarding for Legal Entities
PARP0001436 - Architectural Review Document
Business Scope
Currently, private companies can become customers through digital channels. With the regulation published by the BRSA in May 2023, the way for legal
companies to become customers through digital channels has been paved. In this way, work has begun to implement this project within the scope of
customer acquisition and digitalization.
With DO for Legal Project, it is aimed to ensure that for business customers:
- Ensuring that legal companies become customers through digital means.
- Increasing the number of existing customers.
- Activating a new channel in line with our digitalization goal.
This study, which will be carried out within the scope of the directive published by BRSA in May 2023, includes legal customers. Providing an end-to-end
digital customer experience in the ING Mobile Application.
With the Digital Onboarding for Legal Project, there will be the following controls;
- Identity and Company Information Verification
- Video call
- Opening the Products
- Making CDD by obtaining the required information
Application Architecture
<img width="275" alt="image" src="https://github.com/user-attachments/assets/efa2a171-b195-4f9c-bcd6-a7ce6ab5ff0d">
Data at Rest and in Motion
Data stored on Oracle databases for the applications. Cyberark password wallet are using to store passwords of NPA users for DB
connection. All client and APIs are using TLS on their connections. Data is securely handling and compatible with minimum security
standarts of ING.
There is no new external connection in the scope of in this project. Existing external connection between ING TR and KPS for identity
information, APS for residience and adress information, GIB for tax identification number compliance, KKB for the mobile phone
belongs to the representative, MERSIS for company activity inqueries are using.
Simplified Schematic View of End-State Architecture
<img width="665" alt="image" src="https://github.com/user-attachments/assets/7d6d6a9f-e401-4a71-9886-be8513e4d41f">
LAA Components
<img width="518" alt="image" src="https://github.com/user-attachments/assets/f10b8a41-aa41-4baa-a2cb-ea6c9bb63962">
Architectural Assesment
Compliance with ING Standarts
The product developed in the project is compatible with ING security standarts. From the scalibility perspective the product is not
reusable globally and it’s not running on TPA environment. This product is pure local solution developed in local systems.
Impact Assesment of The Proposed Solution
The systems are designed in accordance with ING minimum standards to handle high volume traffic and transactions. These
systems are scaled according to the increasing number of customers. Since the proposed solution will be used by existing
customers and our rate of increase in customers are certain, no negative impact is expected regarding connections and load.




-->
