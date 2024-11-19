export interface Booking {
    bookingId: number;        // Corresponds to bookingId in the Booking entity
    cabName: string;           // Corresponds to cabName in the Booking entity
    startLocation: string;     // Corresponds to startLocation in the Booking entity
    endLocation: string;       // Corresponds to endLocation in the Booking entity
    tripDate: string;          // Use 'string' to handle dates, or 'Date' with formatting
    duration: string;          // Corresponds to duration in the Booking entity
   // totalPrice: number;        // Corresponds to totalPrice in the Booking entity
  }
  