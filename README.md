# NASASpaceApps-Mapping-WebServices
The mapping webservice project was created as a submission to the Nasa Space Apps challenge.  This project represents the RESTful webservices and database connection layer portion of a much larger project that was developed to solve the Clean Water Mapping challenge.  The mapping webservice was developed leveraging the spring-boot framework with an embeded tomcat instance.  We used a mysql backend for the database portion which was hosted locally for development purposes.  The code base is written using java and maven as the build process. 

The architectural decisions were driven by the reusability provided in using a webservice to access our middleware layer.  This allowed us to have multiple development streams that leveraged the same middleware layer.  The two development streams that we pursued were a website that communicated to our database about the water sample information and an android application that technicians in the field could use to mark clean water sources as soon as they found them.
Link to android project:https://github.com/mikegick/WaterTracker.git

Link to website project:https://github.com/rob0229/NASASpaceApps-WaterMapping_website.git
