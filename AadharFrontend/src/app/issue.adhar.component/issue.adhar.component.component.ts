import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-issue-adhar',
  templateUrl: './issue-adhar.component.html',
  styleUrls: ['./issue-adhar.component.css'],
})
export class IssueAdharComponent implements OnInit {
  issueAdharForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router) {
    this.issueAdharForm = this.formBuilder.group({
      adharNumber: [''],
    });
  }

  ngOnInit(): void {}

  onSubmitAdharForm() {
    // Get the adhar number from the form
    const adharNumber = this.issueAdharForm.get('adharNumber')?.value;

    // Do whatever you need to do with the adhar number, e.g., store it in the backend

    // After processing, navigate back to the admin page
    this.router.navigate(['/admin']);
  }
}
