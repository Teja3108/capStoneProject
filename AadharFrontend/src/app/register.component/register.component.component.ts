import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  url='http://localhost:11000/citizens';
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }
  onAddCitizen(citizenData: { name: string, dob: string, emailid: string, gender: string, mobileno: string, address: string }, form: NgForm) {
    // Check if the user with the same email and name already exists
    this.http.get(this.url, { params: { emailid: citizenData.emailid, name: citizenData.name } })
      .subscribe((responseData: any[]) => {
        if (responseData.length > 0) {
          alert("User with the same email and name already exists!");
        } else {
          // If user doesn't exist, proceed with registration
          this.http.post(this.url, citizenData).subscribe(() => {
            console.log("Registered Successfully!!");
            alert("Registered Successfully!!");
            form.reset();
          }, err => {
            alert("Something Happened!!");
          });
        }
      }, err => {
        alert("Something Happened!!");
      });
  }
}
