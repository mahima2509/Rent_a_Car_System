import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';

import {FormsModule}  from '@angular/forms';
import { AddCabComponent } from './components/cab/addcab/addcab.component';
import { DisplayAllCabComponent } from './components/cab/displayallcab/displayallcab.component';
import { SearchcabComponent } from './components/cab/searchcab/searchcab.component';
//import { AddDriverComponent } from './components/driver/adddriver/adddriver.component';
import { UpdateDriverComponent } from './components/driver/updatedriver/updatedriver.component';
import { SearchdriverComponent } from './components/driver/searchdriver/searchdriver.component';
import { DashboardComponent } from './components/dashboard/dashboard.component'
import { AddDriverComponent } from './components/driver/adddriver/adddriver.component';
import { DisplayAllDriverComponent } from './components/driver/displayalldriver/displayalldriver.component';
import { UpdateCabComponent } from './components/cab/updatecab/updatecab.component';
import { AddBookingComponent } from './components/booking/addbooking/addbooking.component';
import { UpdateBookingComponent } from './components/booking/updatebooking/updatebooking.component';
import { DisplayAllBookingComponent } from './components/booking/displayallbooking/displayallbooking.component';
import { SearchbookingComponent } from './components/booking/searchbooking/searchbooking.component';
import { AddReviewComponent } from './components/review/addreview/addreview.component';
import { UpdateReviewComponent } from './components/review/updatereview/updatereview.component';
import { DisplayAllReviewComponent } from './components/review/displayallreview/displayallreview.component';
import { SearchreviewComponent } from './components/review/searchreview/searchreview.component';
import { LoginComponent } from './startup/login/login.component';
import { SignupComponent } from './startup/signup/signup.component';
import { RouterModule } from '@angular/router';
import { AuthInterceptor } from './auth-interceptor.service';
import { HomeComponent } from './components/home/home/home.component';


@NgModule({
  declarations: [       // components
    AppComponent, AddCabComponent, UpdateCabComponent, DisplayAllCabComponent, SearchcabComponent, AddDriverComponent, UpdateDriverComponent, DisplayAllDriverComponent, SearchdriverComponent, DashboardComponent, AddBookingComponent, UpdateBookingComponent, DisplayAllBookingComponent, SearchbookingComponent, AddReviewComponent, UpdateReviewComponent, DisplayAllReviewComponent, SearchreviewComponent, LoginComponent, SignupComponent, HomeComponent
  ],
  imports: [          // modules
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule

  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true } // Register the interceptor
  ],   // service classes
  bootstrap: [AppComponent]
})
export class AppModule { }
