import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
// import { AdminComponentComponent } from './admin.component/admin.component.component';
// import { AdminhomeComponentComponent } from './adminhome.component/adminhome.component.component';
// import { HomeComponentComponent } from './home.component/home.component.component';
// import { IssueAdharComponentComponent } from './issue.adhar.component/issue.adhar.component.component';
// import { RegisterComponentComponent } from './register.component/register.component.component';
// import { UserComponentComponent } from './user.component/user.component.component';
// import { UserhomeComponentComponent } from './userhome.component/userhome.component.component';

import { AdminComponent } from './admin.component/admin.component.component';
import { AdminhomeComponent } from './adminhome.component/adminhome.component.component';
import { HomeComponent } from './home.component/home.component.component';
import { IssueAdharComponent } from './issue.adhar.component/issue.adhar.component.component';
import { RegisterComponent } from './register.component/register.component.component';
import { UserComponent } from './user.component/user.component.component';
import { UserhomeComponent } from './userhome.component/userhome.component.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    AdminhomeComponent,
    HomeComponent,
    IssueAdharComponent,
    RegisterComponent,
    UserComponent,
    UserhomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
