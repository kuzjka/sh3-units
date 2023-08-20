import { CanMatchFn } from "@angular/router";
import { inject } from "@angular/core";
import { UnitsService } from "./core/units.service";

export const editableGuard: CanMatchFn = () => {
  const dataService = inject(UnitsService);
  return dataService.isEditable();
}
