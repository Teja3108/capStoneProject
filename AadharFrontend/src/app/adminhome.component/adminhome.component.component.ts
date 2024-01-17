import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { map } from 'rxjs/operators';
import { ApiService } from '../api.service.service';
import { UserData } from '../userdata.model.service';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  fetchedUsers: UserData[] = [];
  backendurl = 'http://localhost:11000/citizens';
  updateurl = 'http:localhost:11000/citizens/adhar';

  adharNumber: string; // New property to store the Adhar number

  constructor(
    private http: HttpClient,
    private formBuilder: FormBuilder,
    private api: ApiService
  ) {}

  ngOnInit(): void {
  }

  onFetchUsers() {
    this.fetchUsers();
  }

  fetchUsers() {
    this.http
      .get(this.backendurl)
      .pipe(
        map((responseData) => {
          const userArray: UserData[] = [];
          for (const key in responseData) {
            var x = { ...responseData[key] };
            userArray.push(x);
          }
          return userArray;
        })
      )
      .subscribe((users) => {
        this.fetchedUsers = users;
      });
  }

  onDeleteUser(id: number) {
    this.http.delete(this.backendurl + '/' + id).subscribe((response) => {
      console.log('User deleted: ' + response);
      alert('Closing adhar due to death!');
      location.reload();
    });
  }

  onSubmitIssueAdhar(citizenId: number) {
    console.log('Submitting Adhar number for citizenId:', citizenId);
    console.log('Adhar number:', this.adharNumber);
    // You can access the Adhar number from this.adharNumber
    const adharNumber = this.adharNumber;
    // Make a POST request to your backend API to add the Adhar number
    this.http.post(`${this.backendurl}/${citizenId}/adhar`, adharNumber).subscribe(
        (response: any) => {
            console.log('Response from backend:', response);
            console.log('Adhar number added:', response.message); // Access the success message
            alert('Adhar number added successfully!');
            location.reload();
        },
        (error) => {
            console.error('Error adding Adhar number:', error);
            alert('Failed to add Adhar number. Please try again.');
        }
    );
}
}
