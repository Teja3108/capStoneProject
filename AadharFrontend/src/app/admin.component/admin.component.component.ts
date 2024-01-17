// import { PasswordStrengthValidator } from './../password-strength.validators.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
//import { PasswordStrengthValidator } from "./admin.component.component.spec"
import { PasswordStrengthValidator } from '../password-strength.validators.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  public loginForm!: FormGroup;
  url="http://localhost:11000/admin";
  submitted=false;
  
  constructor(private formBuilder: FormBuilder,private http: HttpClient , private router:Router) { }

  ngOnInit(): void {
    this.loginForm=this.formBuilder.group({
      admin : ['',Validators.required],
      password : ['',Validators.compose([
        Validators.required, PasswordStrengthValidator])]

  })
  }
  onSubmit() {
    this.submitted = true;
    this.login();
  }

  login() {
    this.http.post<any>(this.url, {
      admin: this.loginForm.value.admin,
      password: this.loginForm.value.password
    }).subscribe(res => {
      alert("Login Success,Click Ok to continue!!");
      this.loginForm.reset();
      this.router.navigate(['adminhome']);
    }, err => {
      alert("Try Again!!");
      this.loginForm.reset();
    });
  }
  
    
  }
