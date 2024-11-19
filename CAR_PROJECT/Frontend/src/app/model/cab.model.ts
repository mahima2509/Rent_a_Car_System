// src/app/models/cab.model.ts

export interface Cab {
    cabId: number;
    cabName: string;
    dateOfBook: string; // Use 'string' to manage date as a string, or use 'Date' type with proper formatting
    driverId: number;
  }
export interface CabDetails {
    cabId: number;
    cabName: string;
    dateOfBook: string; // Use 'string' to manage date as a string, or use 'Date' type with proper formatting
    driverId: number;
    driverName: string;
    driverRating: any;
  }


  