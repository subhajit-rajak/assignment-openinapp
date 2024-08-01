<div align="center">

  <img heigh="200" width="200" src="https://github.com/user-attachments/assets/60307d96-7f47-4c28-aaa7-12ce99cbf0b8">
 
# OpenInApp (Assignment)

</div>

> ⚠️ The app is a single pager assignment from OpenInApp for the Android Developer Intern role. This project is independent and has no affiliation with the official OpenInApp application.

## Download

<a href="https://github.com/subhajit-rajak/assignment-openinapp/releases/download/v.1.0.0/OpenInApp.v1.0.0.apk">
<img src="https://github.com/user-attachments/assets/e23364a5-6bd1-4c85-b7a5-5a337af46a56" width="400" /> 
</a>

## UI Instructions
- Access the Figma file for the designated designs at the following location: [Openinapp UI](https://ios.openinapp.co/UITemp)
- Ensure strict adherence to the UI specifications outlined in the Figma file during the implementation process.
- Utilize the prescribed library for the integration of the graph as per the UI design. Populate the graph with data retrieved from the provided API dataset. [Click here for library](https://github.com/PhilJay/MPAndroidChart)
- Enhance user engagement by incorporating a feature to display greetings based on the local time within the application.
- Introduce a dual-tab functionality, namely "Top links" and "Recent links." Implement a list view to present data obtained from the API response in an organized manner.
- Despite the project initially being a single-pager, architect the code in a manner that anticipates future expansion, ensuring the potential for a seamless transition into a complete application encompassing multiple pages.

## Coding Instructions
- Programming Language: Kotlin is mandatory for the successful completion of this assignment.
- Architecture Pattern: Utilize the MVVM (Model-View-ViewModel) architecture pattern for the development of the application.
- API Integration: Employ the specified API for this assignment: https://api.inopenapp.com/api/v1/dashboardNew
- Use the given Token bearer to access and authenticate the API, the bearer token should be used in such a way that you have to use the token for multiple unique API calls.
- Token Management: Ensure that the bearer token is read from local storage during runtime.
- Navigation: Employ Jetpack Navigation for seamless navigation between fragments within the application.
- Codebase: The entire codebase is currently in XML. While adhering to this, you are given the flexibility to choose between XML and Jetpack Compose based on your preference, ensuring the delivery of a high-quality and precise design.
- Networking Layer: Design the networking layer to accommodate both GET and POST API calls, ensuring robust communication with the specified API.
