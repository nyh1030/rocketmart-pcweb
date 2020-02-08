interface ILazyLoadOptions {
	elements_selector?: string;
	container?: HTMLElement;
	threshold?: number;
	thresholds?: string;
	data_src?: string;
	data_srcset?: string;
	data_sizes?: string;
	data_bg?: string;
	class_loading?: string;
	class_loaded?: string;
	class_error?: string;
	load_delay?: number;
	callback_enter?: (elt: HTMLElement) => void;
	callback_exit?: (elt: HTMLElement) => void;
	callback_reveal?: (elt: HTMLElement) => void;
	callback_loaded?: (elt: HTMLElement) => void;
	callback_error?: (elt: HTMLElement) => void;
	callback_finish?: () => void;
	use_native?: boolean;
}
interface ILazyLoad {
	new (options?: ILazyLoadOptions, elements?: NodeListOf<HTMLElement>): ILazyLoad;
	update: (elements?: NodeListOf<HTMLElement>) => void;
	destroy: () => void;
	load: (element: HTMLElement, force?: boolean) => void;
	loadAll: () => void;
}
declare var LazyLoad: ILazyLoad;
export default LazyLoad;
