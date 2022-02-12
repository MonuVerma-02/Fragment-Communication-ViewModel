# FragmentCommunication  - Using Shared ViewModel


<img align="right" src="https://bit.ly/3uKi1bv" width="300">

Sample app that demonstrates the usage of Shared ViewModel with Fragment Communication.<br/>
Including:  
 * ViewModel
 * LiveData
 * Fragment

<br/>

 ## 🚀 Learning Tips:

 - I want to send data from sender fragment to receiver fragment and vice versa, using Shared ViewModel.
 - First, Added Fragments(Sender & Receiver) in Activity.
 - Created ViewModel inside that write getter & setter function for both fragments(Sender & receiver) and hold data using live data.
 - After implement the viewmodel logic, the same ViewModel used for both fragments and observe it and notify it to particular components(UI) about the change.
 - This is simple steps to achieve fragment communication using Shared ViewModel.