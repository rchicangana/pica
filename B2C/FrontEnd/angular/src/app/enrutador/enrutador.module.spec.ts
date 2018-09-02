import { EnrutadorModule } from './enrutador.module';

describe('EnrutadorModule', () => {
  let enrutadorModule: EnrutadorModule;

  beforeEach(() => {
    enrutadorModule = new EnrutadorModule();
  });

  it('should create an instance', () => {
    expect(enrutadorModule).toBeTruthy();
  });
});
