import { Component, OnInit } from '@angular/core';
import { Booking } from 'src/app/model/booking.model'; // Import the Booking model
import { BookingService } from 'src/app/services/booking.service'; // Import the Booking service

@Component({
  selector: 'app-displayallbooking', // Update the selector for booking context
  templateUrl: './displayallbooking.component.html', // Update the template URL
  styleUrls: ['./displayallbooking.component.css'] // Update the style URL if necessary
})
export class DisplayAllBookingComponent implements OnInit {

  bookingList: Booking[] = []; // Booking array to hold fetched data

  constructor(private bookingService: BookingService) {} // Inject the BookingService

  ngOnInit(): void {
    this.getAllBookings(); // Fetch all bookings on initialization
  }

  getAllBookings() {
    this.bookingService.getAll().subscribe(
      (list) => {
        this.bookingList = list; // Assign fetched bookings to bookingList
        console.log('Fetched bookings:', list);
      },
      (error) => {
        console.error('Error fetching bookings:', error);
      }
    );
  }

  deleteById(bookingId: number) {
    this.bookingService.delete(bookingId).subscribe(
      (msg) => {
        console.log('Deleted:', msg); // Log success message
        this.getAllBookings(); // Refresh the list after deletion
      },
      (error) => {
        console.error('Error deleting booking:', error); // Handle errors gracefully
      }
    );
  }
}
