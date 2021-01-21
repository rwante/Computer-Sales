import { Pipe, PipeTransform } from '@angular/core';
import {Laptop} from '../../model/laptop/laptop';

@Pipe({
  name: 'laptopFilter'
})
export class LaptopFilterPipe implements PipeTransform {

  transform(value: Laptop[], filterText?: string): Laptop[] {
    filterText = filterText ? filterText.toLocaleLowerCase() : null;

    return filterText ? value.filter((c: Laptop) => c.brand.toLocaleLowerCase().indexOf(filterText) !== -1) : value;
  }
}
