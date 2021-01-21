import { Pipe, PipeTransform } from '@angular/core';
import {Ram} from '../../model/ram/ram';

@Pipe({
  name: 'ramFilter'
})
export class RamFilterPipe implements PipeTransform {

  transform(value: Ram[], filterText?: string): Ram[] {
    filterText = filterText ? filterText.toLocaleLowerCase() : null;

    return filterText ? value.filter((c: Ram) => c.brand.toLocaleLowerCase().indexOf(filterText) !== -1) : value;
  }
}
