import { Component } from '@angular/core';
import { Driver } from 'src/app/model/driver.model'; // Update the import to Driver model
import { DriverService } from 'src/app/services/driver.service'; // Update to Driver service
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-adddriver', // Update the selector to reflect driver context
  templateUrl: './adddriver.component.html', // Update the template URL accordingly
  styleUrls: ['./adddriver.component.css'] // Update the style URL if necessary
})
export class AddDriverComponent {

  constructor(private driverService: DriverService) {} // Update service injection

  insertDriver(data: Driver) { // Change parameter type to Driver
    this.driverService.insert(data) // Use driver service to insert driver data
      .subscribe(
        (driver) => {
          console.log('Added Driver is: ', driver);
          alert('Driver added successfully!');
        },
        (error) => {
          console.error('Error adding driver: ', error);
          alert('Failed to add driver. Please try again.');
        }
      );
  }
}
