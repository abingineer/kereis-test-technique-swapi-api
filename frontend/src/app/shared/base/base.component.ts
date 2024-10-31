import {Component, OnDestroy} from '@angular/core';
import {Subject} from 'rxjs';

@Component({
  selector: 'app-base',
  standalone: true,
  imports: [],
  templateUrl: './base.component.html',
  styleUrl: './base.component.scss'
})
export abstract class BaseComponent implements OnDestroy{
  unsubscribe$ = new Subject<boolean>();
  ngOnDestroy(): void {
    this.unsubscribe$.next(true);
    this.unsubscribe$.unsubscribe();
  }
}
