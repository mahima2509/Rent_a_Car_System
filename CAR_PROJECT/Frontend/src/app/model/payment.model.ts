export interface Payment {
    paymentId: number;         // Corresponds to paymentId in the Payment entity
    paymentType: string;        // E.g., Credit Card, UPI, etc.
    cardNumber: string;         // Corresponds to cardNumber in the Payment entity
    expiryDate: string;         // Corresponds to expiryDate in the Payment entity
    cvv: number;                // Corresponds to cvv in the Payment entity
    amount: number;             // Corresponds to amount in the Payment entity
  
    customerId: number;         // Corresponds to customerId in the Payment entity
    customerName: string;       // Corresponds to customerName in the Payment entity
  
    cabId: number;              // Corresponds to cabId in the Payment entity
    cabName: string;            // Corresponds to cabName in the Payment entity
  
    transactionDate: string;    // Use 'string' or 'Date' with appropriate formatting
  }
  