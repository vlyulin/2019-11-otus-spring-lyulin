import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { StandardReceiptDetailComponent } from 'app/entities/standard-receipt/standard-receipt-detail.component';
import { StandardReceipt } from 'app/shared/model/standard-receipt.model';

describe('Component Tests', () => {
  describe('StandardReceipt Management Detail Component', () => {
    let comp: StandardReceiptDetailComponent;
    let fixture: ComponentFixture<StandardReceiptDetailComponent>;
    const route = ({ data: of({ standardReceipt: new StandardReceipt(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [StandardReceiptDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(StandardReceiptDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(StandardReceiptDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load standardReceipt on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.standardReceipt).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
