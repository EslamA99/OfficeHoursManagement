# OfficeHoursManagement
Web App for managing office hours for staff members and students

General Requirements: 
1. Project must include mechanisms for signing up, signing in, and signing out. 
2. Signing up process should include the following 
  a. The form must use a captcha whether online or offline like “google captcha” …etc. 
  b. During the registration the user will not supply a password 
  c. After the form submission an email (real email you can look at java mail as an example) will be sent to the user with a generated temporary password to login 
  the application with it. 
3. All users should be able to change their information in the profile page like password, display name…etc. except for the username. 
4. Sessions must be enforced with the user’s interaction. 
5. The project must use a unified CSS style for all the pages you can build your own or. 
6. Ajax should be used in at least three different scenarios including signing up (to check if the user registered before). 
7. All input forms must be validated either by using Java script
8. Every interaction from the user must be presented with a proper feedback from the system like success / failure messages, alert…etc. 

There are two user groups which are “Students” and “Staff Members”.

Students can:
  1. Find staff of each subject. 
  2. Find the contact for a specific staff member. 
  3. View the office hours schedule for the staff member. 
  4. Reserve an appointment with staff member at specific slot and date. 
  5. Cancel a meeting reservation. 
  6. Message staff member of specific subject (specific TA, Dr or all subject Tas…etc.) directly.  
  7. Get notification on the day of the meeting by email (real email message – can use javamail or any other email libraries) and on the system. 
  8. Get notification of a reservation cancellation same as requirement No.7
  
Also Staff members can:
  1. View and reply to students’ messages. 
  2. Message specific student or other staff members. 
  3. Message subject team (other Drs. And Tas. Of the subject). 
  4. Search for a student and view his/her contact details. 
  5. View reservation on a specific office hours slot. 
  6. Cancel slot reservations on a specific date or all the slots on a certain day 
  7. View history of reservations by (slot, from date – to date …etc.). 
  8. Manage office hours slots (time, online / offline, location …etc.). 
  9. Get notifications of messages and students’ reservation by email (real email message – can use java mail or any other email libraries) and on the system. 
  10. Get notification of a reservation cancellation same as requirement No.8 
  11. Get notification on the day of the meeting same as requirement No.8 
  
This a picture of first page of my program (Welcome Page)
  
![Welcome Page](https://user-images.githubusercontent.com/36113402/204589158-77e9f003-6e29-4134-81fa-1dabf252d68a.PNG)

