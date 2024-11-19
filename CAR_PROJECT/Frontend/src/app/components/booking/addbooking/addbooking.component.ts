import { Component } from '@angular/core';
import { Booking } from 'src/app/model/booking.model';  // Import the Booking model
import { BookingService } from 'src/app/services/booking.service';  // Import the Booking service
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-addbooking',  // Update the selector to reflect booking context
  templateUrl: './addbooking.component.html',  // Adjust the template URL
  styleUrls: ['./addbooking.component.css']  // Adjust the style URL if necessary
})
export class AddBookingComponent {

  constructor(private bookingService: BookingService) {}  // Inject the Booking service

  insertBooking(data: Booking) {  // Change parameter type to Booking
    this.bookingService.insert(data)  // Use Booking service to insert booking data
      .subscribe(
        (Booking) => {
          console.log('Added Booking is: ', Booking);
          alert('Booking added successfully!');
        },
        (error) => {
          console.error('Error adding booking: ', error);
          alert('Failed to add booking. Please try again.');
        }
      );
  }
}
