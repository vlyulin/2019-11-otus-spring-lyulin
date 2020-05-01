import { TestBed } from '@angular/core/testing';
import { CommentService } from './comment.service';
describe('CommentService', () => {
    let service;
    beforeEach(() => {
        TestBed.configureTestingModule({});
        service = TestBed.inject(CommentService);
    });
    it('should be created', () => {
        expect(service).toBeTruthy();
    });
});
//# sourceMappingURL=comment.service.spec.js.map