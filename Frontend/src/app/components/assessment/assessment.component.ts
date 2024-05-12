import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Wishlist } from 'src/app/models/wishlist';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-assessment',
  templateUrl: './assessment.component.html',
  styleUrls: ['./assessment.component.css']
})
export class AssessmentComponent implements OnInit {

  loggedUser = '';
  currRole = '';
  assessment: any;
  constructor() { }

  ngOnInit(): void
  {
    
    this.loggedUser = JSON.stringify(sessionStorage.getItem('loggedUser')|| '{}');
    this.loggedUser = this.loggedUser.replace(/"/g, '');

    this.currRole = JSON.stringify(sessionStorage.getItem('ROLE')|| '{}'); 
    this.currRole = this.currRole.replace(/"/g, '');

      this.assessment = [
        {
        skilllevel: 'B2',
        language: 'German',
        coursetype: 'Website',
        websiteurl: 'https://www.testgorilla.com/test-library/language-tests/german-intermediate-b2-test/',
        desc: 'The German (upper-intermediate/B2) test examines candidates German language proficiency within the B2 level of the CEFR framework.',
        time: '10 min',
      }, {
        skilllevel: 'C1',
        language: 'Hindi',
        coursetype: 'Website',
        websiteurl: 'https://www.testgorilla.com/test-library/language-tests/hindi-advanced-c1-test/',
        desc: 'This Hindi (advanced/C1) test examines candidates Hindi proficiency within the C1 level of the CEFR framework.',
        time: '12 min'

      }]
  }
  
  openURL(url : string)
  {
    (window as any).open(url, "_blank");
  }
}
