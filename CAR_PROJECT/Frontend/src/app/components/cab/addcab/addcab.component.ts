import { Component } from '@angular/core';
import { Cab } from 'src/app/model/cab.model';
import { CabService } from 'src/app/services/cab.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-addcab', // Update the selector to reflect cab context
  templateUrl: './addcab.component.html', // Update the template URL accordingly
  styleUrls: ['./addcab.component.css'] // Update the style URL if necessary
})
export class AddCabComponent {
  
  constructor(private cabService: CabService) {} // Update service injection

  insertCab(data: Cab) { // Change parameter type to Cab
    this.cabService.insert(data) // Use cab service to insert cab data
      .subscribe(
        (cab) => {
          console.log('Added Cab is: ', cab);
          alert('Cab added successfully!');
        },
        (error) => {
          console.error('Error adding cab: ', error);
          alert('Failed to add cab. Please try again.');
        }
      );
  }
}
