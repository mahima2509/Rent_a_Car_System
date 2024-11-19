import { Component } from '@angular/core';
import { Driver } from 'src/app/model/driver.model'; // Update the import to refer to the Driver model
import { DriverService } from 'src/app/services/driver.service'; // Update the service reference to DriverService

@Component({
  selector: 'app-updatedriver', // Update the selector to reflect driver context
  templateUrl: './updatedriver.component.html', // Update the template file name
  styleUrls: ['./updatedriver.component.css'] // Update the style file name
})
export class UpdateDriverComponent { // Change class name to UpdateDriverComponent

  constructor(private driverService: DriverService) {} // Change to DriverService

  updateDriver(data: Driver) { // Change parameter type to Driver
    this.driverService.update(data) // Use DriverService for updating
      .subscribe(
        (driver) => { 
          console.log('Updated Driver is: ', driver);
          alert('Driver updated successfully!'); // Update alert message
        },
        (error) => {
          console.error('Error updating driver: ', error);
          alert('Failed to update driver. Please try again.'); // Handle error
        }
      );
  }
}
