import { Component } from '@angular/core';
import { Cab } from 'src/app/model/cab.model'; // Import the Driver model
import { CabService} from 'src/app/services/cab.service'; // Import the DriverService

@Component({
  selector: 'app-updatecab', // Update the selector to reflect driver context
  templateUrl: './updatecab.component.html', // Make sure to use the correct template file
  styleUrls: ['./updatecab.component.css'] // Update the style file as necessary
})
export class UpdateCabComponent { // Ensure the class name reflects the component purpose

  constructor(private cabService: CabService) {} // Inject DriverService

  updatecab(data: Cab) { // The method takes a Driver object as input
    this.cabService.update(data) // Call the update method from DriverService
      .subscribe(
        (Cab) => { 
          console.log('Updated Cab is: ', Cab); // Log the response for debugging
          alert('Cab updated successfully!'); // Notify the user of success
        },
        (error) => {
          console.error('Error updating cab: ', error); // Log any errors for debugging
          alert('Failed to update cab. Please try again.'); // Notify the user of failure
        }
      );
  }
}
