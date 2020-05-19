import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { OracleCloudAppExtensionTestModule } from '../../../test.module';
import { CustomerAccountSitesLOVDetailComponent } from 'app/entities/customer-account-sites-lov/customer-account-sites-lov-detail.component';
import { CustomerAccountSitesLOV } from 'app/shared/model/customer-account-sites-lov.model';

describe('Component Tests', () => {
  describe('CustomerAccountSitesLOV Management Detail Component', () => {
    let comp: CustomerAccountSitesLOVDetailComponent;
    let fixture: ComponentFixture<CustomerAccountSitesLOVDetailComponent>;
    const route = ({ data: of({ customerAccountSitesLOV: new CustomerAccountSitesLOV(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [OracleCloudAppExtensionTestModule],
        declarations: [CustomerAccountSitesLOVDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(CustomerAccountSitesLOVDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(CustomerAccountSitesLOVDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load customerAccountSitesLOV on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.customerAccountSitesLOV).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
