import { Component } from '@angular/core';
import { SalesPerson } from './sales-person';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-sales-person-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './sales-person-list-bootstrap.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent {
  salesPersonList: SalesPerson[] = [
    new SalesPerson("Özgür", "Uçar", "ozgurucar@deneme.com", 90000),
    new SalesPerson("Test", "Eder", "testeder@deneme.com", 50000),
    new SalesPerson("Ahmet", "Demir", "ahmetdemir@deneme.com", 30000),
    new SalesPerson("Melissa", "Vargas", "melissavargas@deneme.com", 65000),
    new SalesPerson("Stephen", "Curry", "stephencurry@deneme.com", 50000),


  ];
}
