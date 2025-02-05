import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCatElemComponent } from './view-cat-elem.component';

describe('ViewCatElemComponent', () => {
  let component: ViewCatElemComponent;
  let fixture: ComponentFixture<ViewCatElemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewCatElemComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewCatElemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
