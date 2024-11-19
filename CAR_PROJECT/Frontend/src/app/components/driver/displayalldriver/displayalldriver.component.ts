import { Component } from '@angular/core';
import { Driver } from 'src/app/model/driver.model'; // Update the import to refer to the Driver model
import { DriverService } from 'src/app/services/driver.service'; // Update the service reference to DriverService

@Component({
  selector: 'app-displayalldriver', // Update the selector to reflect driver context
  templateUrl: './displayalldriver.component.html', // Update the template URL accordingly
  styleUrls: ['./displayalldriver.component.css'] // Update the style URL if necessary
})
export class DisplayAllDriverComponent {
  
  driverList: Driver[] = []; // Change the list to Driver[]

  constructor(private driverService: DriverService) {} // Update service injection

  ngOnInit() {
    this.getAllDrivers(); // Change method name to get all drivers
  }

  getAllDrivers() {
    this.driverService.getAll().subscribe(
      (list) => {
        this.driverList = list; // Assign the fetched drivers to driverList
        console.log(list);
      }
    );
  }

  //deleteById(driverId: number) { // Change parameter to driverId
   // this.driverService.delete(driverId).subscribe((msg) => {
    //  console.log("Deleted: " + msg);
    //  this.getAllDrivers(); // Refresh the list after deletion
   // });}
    deleteById(driverId: number) {
      this.driverService.delete(driverId).subscribe(
        (msg) => {
          console.log(msg); // Log success message from backend
          this.getAllDrivers(); // Refresh the cab list
        },
        (error) => {
          console.error('Error deleting driver:', error); // Handle errors gracefully
        }
      );
  }
}

