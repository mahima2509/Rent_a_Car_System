export interface Review {
    reviewId: number;       // Corresponds to reviewId in the Review entity
    customerName: string;   // Corresponds to customerName in the Review entity
    driverName: string;     // Corresponds to driverName in the Review entity
    rating: number;         // Corresponds to rating in the Review entity (1-5)
    comments: string;       // Corresponds to comments in the Review entity
  }
  