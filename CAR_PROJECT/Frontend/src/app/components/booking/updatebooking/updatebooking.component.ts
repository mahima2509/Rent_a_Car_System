import { Component } from '@angular/core';
import { Booking } from 'src/app/model/booking.model'; // Import Booking model
import { BookingService } from 'src/app/services/booking.service'; // Import Booking service

@Component({
  selector: 'app-updatebooking', // Update the selector to reflect booking context
  templateUrl: './updatebooking.component.html', // Update the template URL
  styleUrls: ['./updatebooking.component.css'] // Update the style URL
})
export class UpdateBookingComponent { // Change class name to UpdateBookingComponent

  constructor(private bookingService: BookingService) {} // Inject BookingService

  updateBooking(data: Booking) { // Change parameter type to Booking
    this.bookingService.update( data) // Use BookingService for updating
      .subscribe(
        (updatedBooking) => {
          console.log('Updated Booking is: ', updatedBooking);
          alert('Booking updated successfully!'); // Success message
        },
        (error) => {
          console.error('Error updating booking: ', error);
          alert('Failed to update booking. Please try again.'); // Handle error
        }
      );
  }
}
