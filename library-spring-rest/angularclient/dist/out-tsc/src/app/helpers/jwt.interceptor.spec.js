import { TestBed } from '@angular/core/testing';
import { JwtInterceptor } from './jwt.interceptor';
describe('JwtInterceptorInterceptor', () => {
    beforeEach(() => TestBed.configureTestingModule({
        providers: [
            JwtInterceptor
        ]
    }));
    it('should be created', () => {
        const interceptor = TestBed.inject(JwtInterceptor);
        expect(interceptor).toBeTruthy();
    });
});
//# sourceMappingURL=jwt.interceptor.spec.js.map