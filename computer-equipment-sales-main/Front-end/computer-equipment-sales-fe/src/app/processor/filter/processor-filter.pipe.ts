import { Pipe, PipeTransform } from '@angular/core';
import {Processor} from '../../model/processor/processor';

@Pipe({
  name: 'processorFilter'
})
export class ProcessorFilterPipe implements PipeTransform {

  transform(value: Processor[], filterText?: string): Processor[] {
    filterText = filterText ? filterText.toLocaleLowerCase() : null;

    return filterText ? value.filter((c: Processor) => c.brand.toLocaleLowerCase().indexOf(filterText) !== -1) : value;
  }
}
