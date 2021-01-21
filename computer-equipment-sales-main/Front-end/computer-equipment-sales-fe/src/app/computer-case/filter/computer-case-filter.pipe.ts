import { Pipe, PipeTransform } from '@angular/core';
import {ComputerCase} from '../../model/computer-case/computer-case';

@Pipe({
  name: 'computerCaseFilter'
})
export class ComputerCaseFilterPipe implements PipeTransform {

  transform(value: ComputerCase[], filterText?: string): ComputerCase[] {
    filterText = filterText ? filterText.toLocaleLowerCase() : null;

    return filterText ? value.filter((c: ComputerCase) => c.brand.toLocaleLowerCase().indexOf(filterText) !== -1) : value;
  }

}
