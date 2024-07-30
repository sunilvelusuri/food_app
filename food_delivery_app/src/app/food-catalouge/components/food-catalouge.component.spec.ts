import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FoodCatalougeComponent } from './food-catalouge.component';

describe('FoodCatalougeComponent', () => {
  let component: FoodCatalougeComponent;
  let fixture: ComponentFixture<FoodCatalougeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FoodCatalougeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FoodCatalougeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
